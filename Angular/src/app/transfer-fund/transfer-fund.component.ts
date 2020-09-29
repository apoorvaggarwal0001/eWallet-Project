import { Component, OnInit } from '@angular/core';
import { TransferFundServiceService } from './transfer-fund-service.service';
import { Router } from '@angular/router';
import { TransferForm } from './TransferForm';
import { WalletTransaction } from '../transaction/walletTransaction';

@Component({
  selector: 'app-transfer-fund',
  templateUrl: './transfer-fund.component.html',
  styleUrls: ['./transfer-fund.component.css']
})
export class TransferFundComponent implements OnInit {

  transferForm: TransferForm=new TransferForm();
  submitted=false;
  invalidAccount=false;
  insufficientBalance=false;
msg:String;
errorMsg:String;
  constructor(private service: TransferFundServiceService,private router: Router) {}

   onSubmit(

   ){
    this.submitted=true;
    this.save();
  }
  save(){
    this.service.transferMoney(this.transferForm).subscribe(
      (data)=>{
        console.log(data);
        // this.msg=data.message;
        this.msg='Your transaction was successful!';
        this.errorMsg=undefined;
      },
      error=>{
        console.log(error);
        this.errorMsg=error.error.msg;
        this.msg=undefined;
      }
    );
    this.goToList();
  }
goToList(){
  // this.router.navigate(['/alltransactions']);
}
  ngOnInit(): void {
  }

}
