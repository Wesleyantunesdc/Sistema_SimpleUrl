import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    pathMatch:'full',
    path: "",
    redirectTo: "principal"
  },
  {
    path: "principal",
    loadChildren: () => import('./principal/principal.module').then(p =>
      p.PrincipalModule)
  }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
