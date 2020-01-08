import React, {useState} from 'react';

const CreateOrEditIngredientForm = (props) => {
    const isValidInput = (ingredient) => {
        return ingredient.name &&
            +ingredient.amount &&
            +ingredient.amount > 0 &&
            ingredient.name.length < 50 &&
            ingredient.amount.toString().length < 50;
    };

    const [ingredient, setIngredient] = useState({
        ...props.ingredient,
        disableSave: !isValidInput(props.ingredient)
    });

    const submitHandler = (e) => {
        e.preventDefault();

        const form = e.target;
        props.submitHandler({
            name: props.isEdit ? props.ingredient.name : form.ingredient.value,
            amount: +form.amount.value,
            veggie: form.veggie.checked,
            spicy: form.spicy.checked
        });
    };

    const resetHandler = (e) => {
        e.preventDefault();

        setIngredient({
            ...props.ingredient,
            disableSave: !isValidInput(props.ingredient)
        });
    };

    const handleChange = ({target}) => {
        setIngredient(prevState => {
            const newValue =
                target.type === 'checkbox' ?
                    {[target.name]: !prevState[target.name]} :
                    {[target.name]: target.value};

            const newState = {
                ...prevState,
                ...newValue
            };

            return isValidInput(newState) ? {
                ...newState,
                disableSave: false
            } : {
                ...newState,
                disableSave: true
            }
        });
    };

    return (
        <div className="row">
            <div className="card mx-auto text-center">
                <div className="card-header">
                    <h4 className="text-center text-uppercase text-info">
                        {props.title} Ingredient
                        {props.isEdit ? ` - ${props.ingredient.name}` : ''}
                    </h4>
                </div>
                <div className="card-body">
                    <form onSubmit={submitHandler} onReset={resetHandler} className="container">
                        {
                            props.isEdit ?
                                null :
                                <div className="row form-group">
                                    <label htmlFor="ingredient" className="col-sm-6 text-left">
                                        Ingredient name
                                    </label>
                                    <div className="col-sm-6">
                                        <input type="text" className="form-control" name="name" id="ingredient"
                                               placeholder="Ingredient name" value={ingredient.name}
                                               onChange={handleChange} />
                                    </div>
                                </div>
                        }

                        <div className="row form-group">
                            <label htmlFor="amount" className="col-sm-6 text-left">
                                Amount
                            </label>
                            <div className="col-sm-6">
                                <input type="text" className="form-control" name="amount" id="amount"
                                       placeholder="Amount" value={ingredient.amount}
                                       onChange={handleChange} />
                            </div>
                        </div>

                        <div className="row form-group">
                            <label htmlFor="veggie" className="col-sm-6 text-left">
                                Veggie
                            </label>
                            <div className="col-sm-6 col-xl-4">
                                <input type="checkbox" className="form-check-input" name="veggie" id="veggie"
                                       checked={ingredient.veggie}
                                       onChange={handleChange} />
                            </div>
                        </div>

                        <div className="row form-group">
                            <label htmlFor="spicy" className="col-sm-6 text-left">
                                Spicy
                            </label>
                            <div className="col-sm-6 col-xl-4">
                                <input type="checkbox" className="form-check-input" name="spicy" id="spicy"
                                       checked={ingredient.spicy}
                                       onChange={handleChange} />
                            </div>
                        </div>

                        <div className="row form-group">
                            <div className="col-sm-4 text-center">
                                <button disabled={ingredient.disableSave} type="submit"
                                        className="btn btn-primary text-uppercase">
                                    Save
                                </button>
                            </div>
                            <div className="col-sm-4 text-center">
                                <button type="reset" className="btn btn-warning text-uppercase">
                                    Reset
                                </button>
                            </div>
                            <div className="col-sm-4 text-center">
                                <button type="button" onClick={props.cancelHandler}
                                        className="btn btn-danger text-uppercase">
                                    Cancel
                                </button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    );
};

export default CreateOrEditIngredientForm;