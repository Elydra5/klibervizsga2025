import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { SefListaComponent } from './sef-lista/sef-lista.component';
import { BerlesComponent } from './berles/berles.component';

const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'sefek', component: SefListaComponent},
  {path: 'berles/:id', component: BerlesComponent},
  {path: '', redirectTo: '/home', pathMatch: 'full'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
