import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { UserComponent } from './components/user/user.component';
import { CommonModule } from '@angular/common';
import { UserService } from './services/user.service';

@NgModule({
declarations: [
    AppComponent,
    UserComponent
  ],
  imports: [CommonModule],
  providers: [
    UserService,
  ],
})
export class AppModule { }