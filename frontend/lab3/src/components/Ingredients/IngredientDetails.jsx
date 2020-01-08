import React, { useEffect, useState } from 'react';
import {useParams, useHistory} from 'react-router-dom';
import IngredientService from '../../services/Ingredients/IngredientService';
import { Link } from 'react-router-dom';

const IngredientDetails = (props) => {
    console.log(props);


    const {name} = useParams();
    console.log(name);
    const [ingredient,setIngredient] = useState({});
    // const { ingredient } = props.location.state;
    const [pizzaForIngredient, setPizzasForIngredient] = useState({});
    const history = useHistory();

    useEffect(() => {
        IngredientService.getIngredient(name).then((data)=>{
            setIngredient(data);
        })
    },[])

    useEffect(() => {
        IngredientService.fetchPizzasForIngredient(ingredient.name)
            .then(response => {
                    setPizzasForIngredient(response.data);
                },
                error => {
                    console.error(error.response.error);
                });
    }, [ingredient]);

    const deleteIngredient = (ingredientId) => {
        IngredientService.deleteIngredient(ingredientId)
            .then(() => {
                history.push('/ingredients');
            }, error => {
                console.error(error.response.error);
            })
    };

    return (
        <div className="row">
            <div className="card mx-auto text-center">
                <div className="card-header">
                    <h4 className="text-info text-center text-uppercase">Ingredient - {ingredient.name}</h4>
                </div>
                <div className="card-body">
                    <dl className="row">
                        <dt className="col-xs-6 col-sm-4 col-md-5 col-lg-6">Name</dt>
                        <dd className="col-xs-6 col-sm-4 col-md-5 col-lg-6">{ingredient.name}</dd>

                        <dt className="col-xs-6 col-sm-4 col-md-5 col-lg-6">Amount</dt>
                        <dd className="col-xs-6 col-sm-4 col-md-5 col-lg-6">{ingredient.amount}</dd>

                        <dt className="col-xs-6 col-sm-4 col-md-5 col-lg-6">Is Veggie</dt>
                        <dd className="col-xs-6 col-sm-4 col-md-5 col-lg-6">{ingredient.veggie ? 'Yes' : 'No'}</dd>

                        <dt className="col-xs-6 col-sm-4 col-md-5 col-lg-6">Is Spicy</dt>
                        <dd className="col-xs-6 col-sm-4 col-md-5 col-lg-6">{ingredient.spicy ? 'Yes' : 'No'}</dd>
                    </dl>

                    <div className="row">
                        {
                            <div className="table-responsive text-nowrap overflow-auto">
                                <table className="table tr-history table-striped table-hover small">
                                    <thead>
                                    <tr>
                                        <th scope="col">Pizza</th>
                                        <th scope="col">Ingredients</th>
                                        <th scope="col">Is Veggie</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    {
                                        (/*this.pizzasForIngredient ||*/ []).map(p =>
                                            <tr key={p.name}>
                                                <td>{p.name}</td>
                                                <td>{p.ingredients.map(i => i.name).join(', ')}</td>
                                                <td>{p.veggie}</td>
                                            </tr>
                                        )
                                    }
                                    </tbody>
                                </table>
                            </div>
                        }
                    </div>
                </div>
                <div className="card-footer">
                    <Link to={{
                        pathname: `/ingredients/${ingredient.name}/edit`,
                        state: {
                            ingredient: ingredient
                        }
                    }} className="btn btn-block btn-outline-info">
                        <i className="fa fa fa-edit" />&nbsp;Edit
                    </Link>
                    <button onClick={() => deleteIngredient(ingredient.name)}
                            className="btn btn-block btn-outline-danger">
                        <i className="fa fa fa-trash" />&nbsp;Remove
                    </button>
                </div>
            </div>
        </div>
    );
}

export default IngredientDetails;