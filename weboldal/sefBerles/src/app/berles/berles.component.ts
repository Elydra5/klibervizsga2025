import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-berles',
  templateUrl: './berles.component.html',
  styleUrl: './berles.component.css'
})
export class BerlesComponent {
  selectedChef: any;
  startDate: string = '';
  endDate: string = '';

  firebaseUrl = 'https://p161-7ddfd-default-rtdb.europe-west1.firebasedatabase.app/chefs.json';
  backendUrl = 'http://localhost:3000/api/berlesek'

  constructor(private route: ActivatedRoute, private http: HttpClient) {
    this.route.params.subscribe(params => {
      const chefId = params['id'];
      this.getChefById(chefId);
    });
  }

  getChefById(id: string) {
    this.http.get<{ [key: string]: any }>(this.firebaseUrl).subscribe(data => {
      const chefs = Object.values(data)
      this.selectedChef = chefs.find((chef: any) => chef.id == id);
    });
  }

  submitBerles() {
    const berlesData = {
      userId: 101,
      chefId: this.selectedChef.id,
      from: this.startDate,
      to: this.endDate
    }
    this.http.post(this.backendUrl, berlesData).subscribe(() => {
      
    })
  }
}
