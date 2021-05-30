import { Component } from '@angular/core';
import {Router} from '@angular/router';
import {AuthService} from './services/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  constructor(private router: Router,
              private authService: AuthService) {
  }

  get loggedIn(): boolean {
    return this.authService.isLoggedIn();
  }

  get show(): boolean {
    return this.router.url === '/login';
  }

  login(): void {
    this.router.navigateByUrl('/login');
  }

  logout(): void {
    this.authService.logout();
  }

}
