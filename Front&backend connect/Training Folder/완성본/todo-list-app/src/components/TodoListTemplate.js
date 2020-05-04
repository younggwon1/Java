import React from 'react';
import './TodoListTemplate.css';
const TodoListTemplate = ({ form, children }) => {
    return (
        <main className="todo-list-template">
            <div className="title">
                오늘 할 일 ({process.env.REACT_APP_TITLE})
            </div>
            <section className="form-wrapper">
                {form}
            </section>
            <section className="todos-wrapper">
                {children}
            </section>
        </main>
    );
};
export default TodoListTemplate;