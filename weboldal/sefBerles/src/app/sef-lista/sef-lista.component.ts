import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';

@Component({
  selector: 'app-sef-lista',
  templateUrl: './sef-lista.component.html',
  styleUrl: './sef-lista.component.css'
})
export class SefListaComponent {

  sefek: any[] = []
  
  startDate: string = '';
  endDate: string = '';

  firebaseUrl = 'https://p161-7ddfd-default-rtdb.europe-west1.firebasedatabase.app/chefs.json'

  constructor(private http:HttpClient) {
    this.getSefek();
  }

  getSefek() {
    this.http.get(this.firebaseUrl).subscribe((data) => {
      this.sefek = data as any[];
    })
  }
}
