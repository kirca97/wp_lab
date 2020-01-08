import axios from '../../custom-axios/axios'
import qs from 'qs'

const IngredientService = {
    fetchIngredients: () => {
        return axios.get("/ingredients");
    },

    getIngredient: (name) => {
        return axios.get("/ingredients/" + name);
    },

    fetchIngredientsPaged: (page, pageSize) => {
        const data = {
            page: page,
            'page-size': pageSize
        };
        const formParams = qs.stringify(data);
        return axios.get("/ingredients", formParams, {
            headers: {
                'page': page, 'page-size': pageSize
            }
        })
    },

    fetchPizzasForIngredient: (name) => {
        /*return axios.get("/ingredients", formParams, {
            headers: {
                'page': page, 'page-size': pageSize
            }
        })*/
    },

    createNewIngredient: (name, spicy, amount, veggie, pizzas) => {
        const data = {
            name: name,
            spicy: spicy,
            amount: amount,
            veggie: veggie,
            pizzas: pizzas
        };
        return axios.post("/ingredients", data, {
            headers: {'Content-Type': 'application/json'}
        });
    },
    updateIngredient: (name, ingredient) => {
        return axios.patch("/ingredients/" + name +"/edit", ingredient, {
            headers: {'Content-Type': 'application/json'}
        });
    },
    deleteIngredient: (ingredientId) => {
        return axios.delete(`/ingredients/${ingredientId}`);
    },
    searchConsultationTerm: (searchTerm) => {
        return axios.get(`/api/consultations?term=${searchTerm}`);
    }
};

export default IngredientService;