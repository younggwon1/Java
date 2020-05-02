import React, { Component } from 'react';
import './Form.css';

class Form extends Component {
    render() {
        const {todo, myChange, myKeyPress, myCreate} = this.props;
        return (
            <div className="form">
                <input value={todo} onChange={myChange} onKeyPress={myKeyPress} />
                <div className="create-button" onClick={myCreate}>
                    추가
                </div>
            </div>
        );
    }
}

export default Form;