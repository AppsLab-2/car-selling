import { Component, OnInit } from '@angular/core';
import {CarService} from '../../services/car.service';
import {ActivatedRoute} from '@angular/router';
import {Car} from '../../models/car';
import {AuthService} from '../../services/auth.service';
import {FavoriteService} from '../../services/favorite.service';

@Component({
  selector: 'app-car-detail',
  templateUrl: './car-detail.component.html',
  styleUrls: ['./car-detail.component.css']
})
export class CarDetailComponent implements OnInit {
  car: Car;
  isFavorite: boolean;

  constructor(private carService: CarService,
              private route: ActivatedRoute,
              private authService: AuthService,
              private favoriteService: FavoriteService) { }

  ngOnInit(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.carService.getCarById(id).subscribe(car => this.car = car);
    if (this.isLoggedIn) {
      this.favoriteService.isCarFavorite(id)
        .subscribe(isFavorite => this.isFavorite = isFavorite);
    }
  }

  get isLoggedIn(): boolean {
    return this.authService.isLoggedIn();
  }

  like(): void {
    this.favoriteService.addCarToFavorite(this.car.id).subscribe();
    this.isFavorite = true;
  }

  unlike(): void {
    this.favoriteService.removeCarFromFavorite(this.car.id).subscribe();
    this.isFavorite = false;
  }


}
