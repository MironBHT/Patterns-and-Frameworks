import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserComponent } from './components/user/user.component';
import { Routes } from '@angular/router';

const routes: Routes = [
  { path: 'user-component', component: UserComponent }
];

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    UserComponent
  ]
})
export class AppRoutingModule { }
