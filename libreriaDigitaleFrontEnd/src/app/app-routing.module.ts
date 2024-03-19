import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CatalogoComponentComponent } from './catalogo-component/catalogo-component.component';
import { LoginComponent } from './login/login.component';

const routes: Routes = [
{path: "catalogo", component:CatalogoComponentComponent},
{path: "login", component:LoginComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
