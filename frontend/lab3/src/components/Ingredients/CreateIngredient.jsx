import React from 'react';
import IngredientService from '../../services/Ingredients/IngredientService';
import { useHistory } from 'react-router-dom';
import CreateOrEditIngredientForm from "./CreateOrEditIngredientForm";

const CreateIngredient = () => {
    const history = useHistory();

    const onSubmitHandler = (ingredient) => {
        IngredientService.createNewIngredient(ingredient.name, ingredient.spicy, ingredient.amount, ingredient.veggie, ingredient.pizzas)
            .then(resp => {
                history.push("/ingredients");
            }, err => {
                const {data} = err.response;
                alert(data.error);
            });
    };

    const onCancelHandler = () => {
        history.goBack();
    };

    return (
        <CreateOrEditIngredientForm
            ingredient={{
                name: '',
                amount: '',
                spicy: false,
                veggie: false
            }}
            title={'Add'}
            submitHandler={onSubmitHandler}
            cancelHandler={onCancelHandler} />
    );
};
export default CreateIngredient;