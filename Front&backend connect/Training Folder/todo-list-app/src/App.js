import React, { Component } from 'react';
import TodoListTemplate from './components/TodoListTemplate';
import Form from './components/Form';
import TodoItemList from './components/TodoItemList';

const initialTodos = new Array(500).fill(0).map(
  (item, idx) => ({ id: idx, text: `일정 ${idx}`, checked: true })
);


class App extends Component {
  id = 3;
  state = {
    todo: '',
    todos: initialTodos
    // todos: [
    //   { id: 0, text: 'todo1', checked: false },
    //   { id: 1, text: 'todo2', checked: true },
    //   { id: 2, text: 'todo3', checked: false }
    // ]
  }

  //Event Handler 함수 정의
  handleChange = (e) => {
    this.setState({
      todo: e.target.value
    });
  };

  handleCreate = () => {
    const { todo, todos } = this.state;
    this.setState({
      todos: todos.concat({ id: this.id++, text: todo, checked: false }),
      todo: ''
    });
  };

  handleKeyPress = (e) => {
    if (e.key === 'Enter') {
      this.handleCreate();
    }
  };

  handleRemove = (id) => {
    const { todos } = this.state;
    this.setState({
      todos: todos.filter(todo => todo.id !== id)
    });
  };

  handleToggle = (id) => {
    const { todos } = this.state;
    // 파라미터로 받은 id 를 가지고 몇번째 Item인지 찾습니다.
    const index = todos.findIndex(todo => todo.id === id);
    const selected = todos[index]; // 선택한 객체
    const copyTodos = [...todos]; // 배열을 복사
    // 기존의 값들을 복사하고, checked 값을 덮어쓰기
    copyTodos[index] = {
      ...selected,
      checked: !selected.checked
    };
    this.setState({
      todos: copyTodos
    });
  }


  render() {
    const { todo, todos } = this.state;
    const { handleChange, handleCreate, handleKeyPress, handleRemove, handleToggle } = this;
    return (
      <div>
        <TodoListTemplate form={<Form todo={todo} myChange={handleChange}
          myCreate={handleCreate}
          myKeyPress={handleKeyPress} />}>
          <TodoItemList todos={todos} myRemove={handleRemove} myToggle={handleToggle} />
        </TodoListTemplate>
      </div>
    );
  }
}
export default App;