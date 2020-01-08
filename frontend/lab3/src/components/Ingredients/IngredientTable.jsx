import React, {Component} from 'react';
import IngredientService from '../../services/Ingredients/IngredientService';
import IngredientTableItem from '../../components/Ingredients/IngredientTableItem';
import {Link} from 'react-router-dom';

class IngredientTable extends Component {
    isLoading = false;

    constructor(props) {
        super(props);
        this.state = {
            ingredients: [],
            isLoaded: false,
            isInitiallyLoaded: false
        }
    }

    componentDidMount() {
        this.isLoading = true;
        this.getIngredients();
    }

    componentWillUnmount() {
        this.isLoading = false;
    }

    getIngredients = () => {
        this.setState({
            isLoaded: false
        })

        IngredientService.fetchIngredients()
            .then(response => {
                console.log(response);
                this.setState({
                    ingredients: response.data.content,
                    isLoaded: true,
                    isInitiallyLoaded: true
                });
                console.log(this.state);
            }, error => {
                this.setState({
                    isLoaded: false,
                    isInitiallyLoaded: true
                })
                console.error(error.response.error)
            });

        console.log(this.state);
    };

    deleteIngredient = (ingredientId) => {
        IngredientService.deleteIngredient(ingredientId)
            .then(response => {
                    this.getIngredients();
                },
                error => {
                    console.error(error.response.error);
                });
    }

    table = () => {
        return <div className="row">
            <h4 className="text-upper text-left">Ingredients</h4>
            <div className="table-responsive">
                <table className="table tr-history table-striped small">
                    <thead>
                    <tr>
                        <th scope="col">Name</th>
                        <th scope="col">Amount</th>
                        <th scope="col">Spicy</th>
                        <th scope="col">Veggie</th>
                        <th scope="col">Actions</th>
                    </tr>
                    </thead>
                    <tbody>
                    {
                        this.state.isLoaded ?
                            this.state.ingredients.map(ingredient =>
                                <IngredientTableItem item={ingredient}
                                                     key={ingredient.name}
                                                     deleteIngredient={this.deleteIngredient}/>
                            ) : <h2>Loading...</h2>

                    }
                    </tbody>
                </table>
            </div>
        </div>
    }

    render() {
        return (
            <div className="mb-3">
                {this.table()}
                <Link to={'/ingredients/new'}
                      className="btn btn-outline-primary">
                    Create ingredient
                </Link>
            </div>
        );
    }
}

export default IngredientTable;