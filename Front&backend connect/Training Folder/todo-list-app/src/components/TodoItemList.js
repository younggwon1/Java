import React, { Component } from 'react';
import TodoItem from './TodoItem';

class TodoItemList extends Component {

    //life-cycle 메서드 overriding : render() 메서드의 호출을 줄일 수 있다.
    shouldComponentUpdate(nextProps, nextState) {
        return this.props.todos !== nextProps.todos;
    }

    render() {
        const { todos, myToggle, myRemove } = this.props;
        const todoList = todos.map(({ id, text, checked }) => (
            <TodoItem id={id} checked={checked} todoText={text} myToggle={myToggle} myRemove={myRemove} key={id} />
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
export default TodoItemList;
