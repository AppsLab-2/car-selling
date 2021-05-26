import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {SearchComponent} from './components/search/search.component';
import {LoginComponent} from './components/login/login.component';
import {CarDetailComponent} from './components/car-detail/car-detail.component';
import {GuideComponent} from './components/guide/guide.component';

const routes: Routes = [
  {path: 'browse', component: SearchComponent},
  {path: 'guide', component: GuideComponent},
  {path: 'login', component: LoginComponent},
  {path: 'detail/:id', component: CarDetailComponent},
  {path: '**', redirectTo: '/browse'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {onSameUrlNavigation: 'reload'})],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
