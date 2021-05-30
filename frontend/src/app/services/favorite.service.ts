import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {Car} from '../models/car';
import {environment} from '../../environments/environment';
import {map} from 'rxjs/operators';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class FavoriteService {

  constructor(private http: HttpClient) { }

  getFavoriteCars(): Observable<Car[]> {
    return this.http.get<Car[]>(`${environment.apiUrl}user/favorite`);
  }

  addCarToFavorite(carId: number): Observable<any> {
    return this.http.post(`${environment.apiUrl}user/addCarToFavorite`, carId);
  }

  removeCarFromFavorite(cardId: number): Observable<any> {
    return this.http.request('delete', `${environment.apiUrl}user/removeCarFromFavorite`, { body: cardId});
  }

  isCarFavorite(carId: number): Observable<boolean> {
    return this.getFavoriteCars().pipe(
      map(cars => {
        return cars.some(car => car.id === carId);
      })
    );
  }
}
