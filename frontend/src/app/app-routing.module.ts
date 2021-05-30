import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {SearchComponent} from './components/search/search.component';
import {LoginComponent} from './components/login/login.component';
import {CarDetailComponent} from './components/car-detail/car-detail.component';
import {FavoriteComponent} from './components/favorite/favorite.component';
import {AuthGuard} from './guards/auth.guard';

const routes: Routes = [
  {path: 'browse', component: SearchComponent},
  {path: 'login', component: LoginComponent},
  {path: 'detail/:id', component: CarDetailComponent},
  {path: 'favorite', component: FavoriteComponent, canActivate: [AuthGuard]},
  {path: '**', redirectTo: '/browse'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {onSameUrlNavigation: 'reload'})],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
