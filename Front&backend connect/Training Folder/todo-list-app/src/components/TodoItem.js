import React, { Component } from 'react';
import './TodoItem.css';
class TodoItem extends Component {

    shouldComponentUpdate(nextProps, nextState) {
        return this.props.checked !== nextProps.checked;
    }

    render() {
        const { todoText, checked, id, myToggle, myRemove } = this.props;
        return (
            <div className="todo-item" onClick={() => myToggle(id)}>
                <div className="remove" onClick={(e) => {
                    // event가 전파되는 것을 방지 되도록
                    e.stopPropagation();
                    myRemove(id);
                }}>
                    &times;
                </div>
                {/* <div className={`todo-text`}> */}
                <div className={`todo-text ${checked && 'checked'}`}>

                    {/* checked가 true인 경우 아래와 같이 실행 */}
                    {/* <div className={`todo-text && 'checked'}`}> */}
                    <div>
                        {todoText}
                    </div>
                </div>
                {
                    checked && (<div className="check-mark">✓</div>)
                }

            </div>
        );
    }
}

export default TodoItem;