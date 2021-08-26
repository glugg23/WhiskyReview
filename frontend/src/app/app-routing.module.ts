import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { WhiskyComponent } from "./pages/whisky/whisky.component";
import { AddDistilleryComponent } from "./pages/add-distillery/add-distillery.component";

const routes: Routes = [
    {path: 'whiskies', component: WhiskyComponent},
    {path: 'add/distillery', component: AddDistilleryComponent}
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule {
}
