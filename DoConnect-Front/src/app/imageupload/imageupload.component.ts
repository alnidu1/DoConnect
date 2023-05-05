import { Component } from '@angular/core';
import { FileUploadService } from '../service/fileupload.service';

@Component({
  selector: 'app-imageupload',
  templateUrl: './imageupload.component.html',
  styleUrls: ['./imageupload.component.css']
})
export class ImageuploadComponent {

  fileToUpload: File | null = null;

  constructor(private fileUploadService: FileUploadService) {}

  handleFileInput(input: HTMLInputElement) {
    const fileToUpload = input.files?.item(0);
  
    if (fileToUpload) {
      this.fileToUpload = fileToUpload;
    }
  }

  uploadImage() {
    if (this.fileToUpload) {
      this.fileUploadService.uploadFile(this.fileToUpload).subscribe(
        (filePath: string) => {
          const image = new Image();
          image.onload = () => {
            const canvas = document.createElement('canvas');
            canvas.width = image.width;
            canvas.height = image.height;
            const ctx: any| null = canvas.getContext('2d');
            ctx.drawImage(image, 0, 0);
            const dataUrl = canvas.toDataURL('image/png');
            const link = document.createElement('a');
            link.download = this.fileToUpload?.name ?? '';
            link.href = dataUrl;
            link.click();
          };
          image.src = filePath;
        },
        error => console.error(error)
      );
    }
  }
  
} 
