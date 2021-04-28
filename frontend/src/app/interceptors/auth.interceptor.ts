import {Injectable} from '@angular/core';
import {
  HttpErrorResponse,
  HttpEvent,
  HttpHandler,
  HttpHeaders,
  HttpInterceptor,
  HttpRequest
} from '@angular/common/http';
import {Observable} from 'rxjs';
import {AuthService} from '../services/auth.service';
import {catchError} from 'rxjs/operators';
import {Router} from '@angular/router';

@Injectable()
export class AuthInterceptor implements HttpInterceptor {

  constructor(private authService: AuthService,
              private router: Router) {
  }

  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
    if (this.authService.isLoggedIn()) {
      request = request.clone({
        headers: new HttpHeaders({
          Authorization: this.authService.getToken()
        })
      });
    }
    return next.handle(request).pipe(
      catchError((err: HttpErrorResponse) => {
        if (this.authService.isLoggedIn() && err.status === 401) {
          this.authService.logout();
          this.router.navigateByUrl('/');
        }
        throw err;
      })
    );
  }
}
