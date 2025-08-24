import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { QrcodeService } from './core/service/qrcode.service';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-root',
  imports: [CommonModule, FormsModule, ReactiveFormsModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  
  constructor(private qrcodeService: QrcodeService) {}

  public generateQRCode(text: string) {
    this.qrcodeService.generateQRCode(text).subscribe(blob => {
      const url = window.URL.createObjectURL(blob);
      const img = document.querySelector('.presentation img') as HTMLImageElement;
      img.src = url;
      // document.body.appendChild(img);
    });
  }

  // public saveQRCode(text: string) {
  //   this.qrcodeService.generateQRCode(text).subscribe(blob => {
  //     const url = window.URL.createObjectURL(blob);
  //     const a = document.createElement('a');
  //     a.href = url;
  //     a.download = 'qrcode.png';
  //     document.body.appendChild(a);
  //     a.click();
  //     document.body.removeChild(a);
  //   });
  // }

}
