import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CatalogoComponentComponent } from './catalogo-component/catalogo-component.component';

const routes: Routes = [
{path: "comp", component:CatalogoComponentComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
