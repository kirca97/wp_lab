import React from 'react';
import { Link } from 'react-router-dom';

const IngredientTableItem = (props) => {
    return (
        <tr>
            <td> { props.item.name } </td>
            <td> { props.item.amount } </td>
            <td> { props.item.veggie ? 'Yes' : 'No' } </td>
            <td> { props.item.spicy ? 'Yes' : 'No' } </td>
            <td>
                <Link to={{
                    pathname: `/ingredients/${props.item.name}/edit`,
                    state: { ingredient: props.item }
                }} className="btn btn-sm btn-secondary"> Edit Ingredient
                </Link>
                {/*<button onClick={ () => props.updateIngredient(props.item.name) }*/}
                {/*        className="btn btn-sm btn-secondary">*/}
                {/*    Edit*/}
                {/*</button>*/}
                <Link to={{
                    pathname: `/ingredients/${props.item.name}/details`,
                    state: { ingredient: props.item }
                }} className="btn btn-sm btn-secondary"> Go to Details
                </Link>
                <button onClick={ () => props.deleteIngredient(props.item.name) }
                        className="btn btn-sm btn-danger">
                    Delete
                </button>
            </td>
        </tr>
    )
}

export default IngredientTableItem;