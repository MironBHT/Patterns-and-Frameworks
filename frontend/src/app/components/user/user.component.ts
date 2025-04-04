import { Component, Input } from '@angular/core';
import { User } from '../../model/User'

@Component({
  selector: 'app-user',
  imports: [],
  templateUrl: './user.component.html',
  styleUrl: './user.component.css'
})
export class UserComponent {
  @Input() user!: User;
  
  ngOnInit(): void {
    this.user = new User();
    this.user.id = 10001;
    this.user.username = 'Hans Beispielname';
    this.user.email = 'hans@mail.com';
    this.user.role = 'User';
    this.user.registrationDate = new Date();
    this.user.feedbacks = [ 'Bad' ];
    this.user.translations = [ 'Good Bye', 'Wiedersehen' ];
}
}
