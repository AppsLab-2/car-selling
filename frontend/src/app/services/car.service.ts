import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../environments/environment';
import {Observable} from 'rxjs';
import {Car} from '../models/car';
import {Brand} from '../models/brand';
import {FilterOptions} from '../models/filterOptions';
import {map} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class CarService {

  constructor(private http: HttpClient) { }

  getCars(): Observable<Car[]> {
    return this.http.get<Car[]>(`${environment.apiUrl}cars`);
  }

  getCarById(id: number): Observable<Car> {
    return this.http.get<Car>(`${environment.apiUrl}cars/${id}`);
  }

  getBrands(): Observable<Brand[]> {
    return this.http.get<Brand[]>(`${environment.apiUrl}brands`);
  }

  getCarTypes(): Observable<string[]> {
    return this.http.get<string[]>(`${environment.apiUrl}cars/type`);
  }

  filterCars(filterOptions: FilterOptions): Observable<Car[]> {
    return this.getCars().pipe(
      map((cars: Car[]) => {
        if (filterOptions.brand) {
          cars = cars.filter((car) => car.brand.name === filterOptions.brand.name);
        }
        if (filterOptions.transmission) {
          cars = cars.filter((car) => car.transmission === filterOptions.transmission);
        }
        if (filterOptions.maxPrice) {
          cars = cars.filter((car) => car.price <= filterOptions.maxPrice);
        }
        if (filterOptions.type) {
          cars = cars.filter((car) => car.type === filterOptions.type);
        }
        return cars;
      })
    );
  }
}
