import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { QrcodeService } from './core/service/qrcode.service';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-root',
  imports: [FormsModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {

  public width: number = 200;
  public height: number = 200;

  constructor(private qrcodeService: QrcodeService) {}

  public get presentationVisible() {
    const img = document.querySelector('.presentation img') as HTMLImageElement;
    return (img.src && img.src !== '') || false;
  }

  public generateQRCode(text: any) {
    console.log(text)
    this.qrcodeService.generateQRCode(text).subscribe(blob => {
      const url = window.URL.createObjectURL(blob);
      const img = document.querySelector('.presentation img') as HTMLImageElement;
      img.src = url;
    });
  }

  public saveQRCode() {
    const img = document.querySelector('.presentation img') as HTMLImageElement;
    const url = img.src;
    const a = document.createElement('a');
    a.href = url;
    a.download = 'qrcode.png';
    document.body.appendChild(a);
    a.click();
    document.body.removeChild(a);
  }

}
