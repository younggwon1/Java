import React, { Component } from 'react';
import TodoItem from './TodoItem';
import { connect } from 'react-redux';
import { fetchAllTodos } from '../actions';

class TodoItemList extends Component {


    componentDidMount() {
        this.props.fetchAllTodos();
    }


    //life-cycle 메서드 overriding : render() 메서드의 호출을 줄일 수 있다.
    shouldComponentUpdate(nextProps, nextState) {
        return this.props.todos !== nextProps.todos;
    }

    render() {
        const { todos } = this.props;
        const todoList = todos.map(({ id, text, checked }) => (
            <TodoItem id={id} checked={checked} todoText={text} key={id} />
        ));
        return (
            <div>
                {/* <TodoItem todoText="할 일1" checked={true}/>
                <TodoItem todoText="할 일2" checked={true}/>
                <TodoItem todoText="할 일3" checked={false}/> */}
                {todoList}
            </div>
        );
    }
}

const mapStateToProps = (state) => {
    return {
        todos: state.todos
    }
}


export default connect(mapStateToProps, { fetchAllTodos })(TodoItemList);
