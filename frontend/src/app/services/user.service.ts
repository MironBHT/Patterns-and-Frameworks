import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
import { User } from '../model/User';

@Injectable({
  providedIn: 'root'
})

export class UserService {
  // should be taken from config, but works for now
  private userUrl = 'http://localhost:8080/api/user';  // Web API

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(private http: HttpClient) { }

  getUsers(): Observable<User[]> {
      return this.http.get<User[]>(this.userUrl)
      .pipe(
          tap(_ => this.log('fetched users')),
          catchError(this.handleError<User[]>('getUsers', []))
        );
  }

  getUser(id: number): Observable<User> {
      const url = `${this.userUrl}/${id}`;
      return this.http.get<User>(url).pipe(
        tap(_ => this.log(`fetched user ID=${id}`)),
        catchError(this.handleError<User>(`getUser ID=${id}`))
      );
  }

  createUser(user: User): Observable<any> {
    const url = `${this.userUrl}`;
    // this.http.post(url, user, this.httpOptions);
    return this.http.post(url, user, this.httpOptions).pipe(
      tap(_ => this.log(`created user ${user.username}`)),
      catchError(this.handleError<User>(`createUser ${user.username}`))
    );
  }

  deleteUser(id: number): Observable<User> {
      const url = `${this.userUrl}/${id}`;
      return this.http.delete<User>(url).pipe(
        tap(_ => this.log(`deleted user ID=${id}`)),
        catchError(this.handleError<User>(`deleteUser ID=${id}`))
      );
  }


  private handleError<T>(operation = 'operation', result?: T) {
      return (error: any): Observable<T> => {
          console.error(error); // log to console for the time being
          this.log(`${operation} failed: ${error.message}`);
          return of(result as T);
      };
  }

  private log(message: string) {
      // this.messageService.add(`UserService: ${message}`);
      console.log(`UserService: ${message}`);
  }
}
