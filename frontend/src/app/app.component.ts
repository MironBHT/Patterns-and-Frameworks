import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { UserService } from './services/user.service';
import { User } from './model/User';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'frontend';
  user!: User;

  constructor(private http: HttpClient, private userService: UserService) { }
  
  createTestUser(): void {
      this.user = new User();
      this.user.id = 10002;
      this.user.username = 'Robert Mustermann';
      this.user.email = 'robertm@mail.com';
      this.user.role = 'User';
      this.user.registrationDate = new Date();
      this.user.feedbacks = [ 'Good' ];
      this.user.translations = [ 'Hallo', 'Hello' ];

      this.userService.createUser(this.user);
  }
}
