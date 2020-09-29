import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { WalletTransaction } from './walletTransaction';
import { TransactionService } from './transaction.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-transaction',
  templateUrl: './transaction.component.html',
  styleUrls: ['./transaction.component.css']
})
export class TransactionComponent implements OnInit {
  transactions:any=[];
  constructor(private service:TransactionService, private router: Router) { }

  ngOnInit(): void {
    this.service.getTransactionList().subscribe(
      (data)=>{
        console.log(data);
        this.transactions=data;
      },
      error=>{
        console.log(error);
      }
    );
  }
}
