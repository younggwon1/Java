import React, { Component } from 'react';
import './Form.css';
import { connect } from 'react-redux';
import { addTodo } from '../actions';

class Form extends Component {
    state = {
        todo: ''
    };

    handleChange = (e) => {
        this.setState({
            todo: e.target.value
        });
    };

    handleCreate = () => {
        const { todo } = this.state;
        //Action 생성함수 호출
        this.props.addTodo({
            text: todo,
            checked: false
        });

        this.setState({
            todo: ''
        });
    };

    handleKeyPress = (e) => {
        if (e.key === 'Enter') {
            this.handleCreate();
        }
    };

    render() {
        const { todo } = this.state;
        const { handleChange, handleCreate, handleKeyPress } = this;
        return (
            <div className="form">
                <input value={todo} onChange={handleChange} onKeyPress={handleKeyPress} />
                <div className="create-button" onClick={handleCreate}>
                    추가
                </div>
            </div>
        );
    }
}

export default connect(null, { addTodo })(Form);
