import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { QRCodeRequest } from '../model/qr-code-request';

@Injectable({
  providedIn: 'root'
})
export class QrcodeService {

  constructor(private httpClient: HttpClient) {}

  public generateQRCode(request: QRCodeRequest) {
    return this.httpClient.post('http://localhost:8080/api/v1', request, { responseType: 'blob' });
  }

}
