import axios from 'axios';

//Action type 정의
export const FETCH_TODOS = "FETCH_TODOS";
export const ADD_TODO = "ADD_TODO";
export const REMOVE_TODO = "REMOVE_TODO";
export const TOGGLE_TODO = "TOGGLE_TODO";

//Server URL
const api_url = process.env.REACT_APP_APIURL;

//Action 생성함수 선언

//1. Todo 목록
export const fetchAllTodos = () => {
    return (dispatch) => {
        axios.get(api_url) //서버 요청
            .then(res => {
                dispatch({
                    // 요청이 성공하면, 서버 응답내용을 payload로 설정하여
                    // FETCH_TODOS 액션을 디스패치 합니다.
                    type: FETCH_TODOS,
                    payload: res.data
                })
            })
            .catch(error => {
                console.error(error);
                throw (error);
            })
    }
}



//2. Todo 등록
export const addTodo = (todo) => {
    return (dispatch) => {
        axios.post(api_url, todo)
            .then(res => {
                dispatch({
                    type: ADD_TODO,
                    payload: res.data
                })
            })
            .catch(error => {
                console.log(error);
                throw (error);
            })
    }
}


//3. Todo 삭제
export const removeTodo = (id) => {
    return (dispatch) => {
        axios.delete(`${api_url}/${id}`)
            .then(res => {
                dispatch({
                    type: REMOVE_TODO,
                    payload: res.data
                })
            })
            .catch(error => {
                console.log(error);
                throw (error);
            })
    }
}

//4. toggle
export const toggleTodo = (todo) => {
    return (dispatch) => {
        axios.put(`${api_url}/${todo.id}`, todo)
            .then(res => {
                dispatch({
                    type: TOGGLE_TODO,
                    payload: res.data
                })
            })
            .catch(error => {
                console.log(error);
                throw (error);
            })
    }
}



