import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { UserService } from './services/user.service';
import { User } from './model/User'

@Component({
  selector: 'app-root',
  imports: [RouterOutlet],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'frontend';
  user!: User;
  
  private userService!: UserService

  createTestUser(): void {
      this.user = new User();
      this.user.id = 10002;
      this.user.userName = "Robert Mustermann";
  
      this.userService.createUser(this.user);
  }
}
