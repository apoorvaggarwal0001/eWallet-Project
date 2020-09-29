import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { TransferForm } from './TransferForm';

@Injectable({
  providedIn: 'root'
})
export class TransferFundServiceService {

  private baseUrl = "http://localhost:9090/transfer";
  private baseUrl1 = "http://localhost:9090/searchtransaction";
  constructor(private http: HttpClient) { }

  searchTransaction(id:number): Observable<any> {
    return this.http.get(`${this.baseUrl1}/${id}`);
  }

  transferMoney(transferForm:Object):Observable<Object> {
    return this.http.post(`${this.baseUrl}/`,transferForm)
  }
}
