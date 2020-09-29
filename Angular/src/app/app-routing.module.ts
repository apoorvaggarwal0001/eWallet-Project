import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TransferFundComponent } from './transfer-fund/transfer-fund.component';
import { TransactionComponent } from './transaction/transaction.component';


const routes: Routes = [
  { path: 'transfer', component: TransferFundComponent },
  { path: 'alltransactions', component: TransactionComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
