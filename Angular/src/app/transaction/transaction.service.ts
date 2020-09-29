import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TransactionService {
  private baseUrl2 = "http://localhost:9090/alltransactions";

  constructor(private http: HttpClient) { }

  getTransactionList():Observable<any>{
    return this.http.get(`${this.baseUrl2}`)
  }
}
