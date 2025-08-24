import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class QrcodeService {

  constructor(private httpClient: HttpClient) {}

  public generateQRCode(text: string) {
    return this.httpClient.post('http://localhost:8080/api/v1', {dataToConvert: text}, { responseType: 'blob' });
  }

}
