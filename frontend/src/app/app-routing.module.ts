import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { WhiskyComponent } from "./pages/whisky/whisky.component";

const routes: Routes = [
    {path: 'whiskies', component: WhiskyComponent}
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule {
}
