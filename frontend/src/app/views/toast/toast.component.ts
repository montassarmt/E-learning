import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ToastService } from '@/app/services/toast.service';


@Component({
  selector: 'app-toast',
  standalone: true,
  imports: [CommonModule],
  template: `
    <div class="toast-container position-fixed bottom-0 end-0 p-3" style="z-index: 1200">
      <div *ngIf="message" class="toast align-items-center text-white border-0 show"
           [ngClass]="toastClass" role="alert" aria-live="assertive" aria-atomic="true">
        <div class="d-flex">
          <div class="toast-body">
            {{ message }}
          </div>
          <button type="button" class="btn-close btn-close-white me-2 m-auto" (click)="close()"></button>
        </div>
      </div>
    </div>
  `
})
export class ToastComponent implements OnInit {
  message = '';
  toastClass = 'bg-info';

  constructor(private toastService: ToastService) {}

  ngOnInit(): void {
    this.toastService.toastState$.subscribe(({ message, type }) => {
      this.message = message;
      this.toastClass = type === 'success' ? 'bg-success' : type === 'error' ? 'bg-danger' : 'bg-info';
      setTimeout(() => this.message = '', 4000);
    });
  }

  close() {
    this.message = '';
  }
}
