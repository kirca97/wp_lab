import React from 'react';
import './App.css';
import Header from "./components/Header";
import {BrowserRouter, Redirect, Route} from "react-router-dom";
import IngredientTable from "./components/Ingredients/IngredientTable";
import Pizzas from "./components/Pizzas";
import CreateIngredient from "./components/Ingredients/CreateIngredient";
import IngredientDetails from "./components/Ingredients/IngredientDetails";
import EditIngredient from "./components/Ingredients/EditIngredient";

function App() {

  const routing = (
      <BrowserRouter>
        <Header/>

        <main role="main" className="mt-3">

          <div className="container">
            <Route path={"/pizzas"} exact render={() =>
                <Pizzas />}>
            </Route>
            <Route path={"/ingredients"} exact render={() =>
                <IngredientTable />}>
            </Route>
            <Route path={"/ingredients/new"}
                   render={() => <CreateIngredient/>}>
            </Route>
            <Route path={"/ingredients/:name/details"}
                   render={() => <IngredientDetails/>}>
            </Route>
            <Route path={"/ingredients/:name/edit"}
                   render={() => <EditIngredient/>}>
            </Route>
            {/*<Route path="/consultations/:termId/edit" render={() =>*/}
            {/*    <ConsultationEdit onSubmit={this.updateConsultation}/>}>*/}
            {/*</Route>*/}
            <Redirect to={"/ingredients"}/>
          </div>
        </main>
      </BrowserRouter>
  );

  return (

      <div className="App">
        {routing}
      </div>
  );
}

export default App;