import { Component, OnInit } from '@angular/core';
import {Car} from '../../models/car';
import {FavoriteService} from '../../services/favorite.service';

@Component({
  selector: 'app-favorite',
  templateUrl: './favorite.component.html',
  styleUrls: ['./favorite.component.css']
})
export class FavoriteComponent implements OnInit {
  cars: Car[];

  constructor(private favoriteService: FavoriteService) { }

  ngOnInit(): void {
    this.favoriteService.getFavoriteCars()
      .subscribe(cars => this.cars = cars);
  }

}
