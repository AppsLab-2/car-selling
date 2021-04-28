import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {tap} from 'rxjs/operators';
import {environment} from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  token: string;

  constructor(
    private readonly httpClient: HttpClient
  ) {
  }

  getToken(): string {
    return this.token;
  }

  isLoggedIn(): boolean {
    return !!this.token;
  }

  login(username: string, password: string): Observable<any> {
    const info = btoa(`${username}:${password}`);
    const token = `Basic ${info}`;
    const options = {
      headers: new HttpHeaders({
        Authorization: token,
        'X-Requested-With': 'XMLHttpRequest'
      }),
      withCredentials: true
    };
    return this.httpClient.get(`${environment.apiUrl}login`, options).pipe(
      tap(() => this.token = token)
    );
  }

  logout(): void {
    this.token = null;
  }

}
