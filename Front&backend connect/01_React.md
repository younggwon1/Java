# React

[Reactjs code snippets](https://marketplace.visualstudio.com/items?itemName=xabikos.ReactSnippets)



http://localhost:3000

**index.html -> index.js -> App.js 흐름으로 진행된다.**



#### Props와 State

- 리액트 컴포넌트에서 다루는 데이터는 props 와 state로 나누어 진다.
- props는 부모 컴포넌트가 자식 컴포넌트에게 주는 값이다.
- 자식 컴포넌트에서는 props를 받아 오기만 하고 props를 수정 할 수 없다.
- 반면에 state는 컴포넌트 내부에서 선언하며 내부에서 값을 변경 할 수 있다.



#### Props [실습]

```js
# App.js

import React, { Component } from 'react';
import MyComponent from './components/MyComponent';

class App extends Component {
  render() {
    return (
      <React.Fragment>
        <MyComponent name="React"/>
      </React.Fragment>
    );
  }
}

export default App;
```



```js
# MyComponent.js

import React, { Component } from 'react';

class MyComponent extends Component {
    render() {
        return (
            <div>
                Hello {this.props.name}
            </div>
        );
    }
}

export default MyComponent;

또는

import React, { Component } from 'react';

class MyComponent extends Component {
    render() {
        const {name} = this.props;
        return (
            <div>
                Hello {name}
            </div>
        );
    }
}

export default MyComponent;
```

![캡처](https://user-images.githubusercontent.com/42603919/80782727-4c5fae80-8bb2-11ea-9303-a157a2983401.PNG)



#### defaultProps

- defaultProps는 props의 기본값을 설정할 때 사용한다.



```js
# App.js

import React, { Component } from 'react';
import MyComponent from './components/MyComponent';

class App extends Component {
  render() {
    return (
      <React.Fragment>
        <MyComponent name="React"/>
        <MyComponent />
      </React.Fragment>
    );
  }
}

export default App;
```



```js
# MyComponent.js

import React, { Component } from 'react';

class MyComponent extends Component {
    render() {
        const {name} = this.props;
        return (
            <div>
                Hello {name}
            </div>
        );
    }
}

MyComponent.defaultProps = {
    name:'리액트'
};
export default MyComponent;
```

![캡처](https://user-images.githubusercontent.com/42603919/80782920-f3444a80-8bb2-11ea-94ed-aae361422db1.PNG)



#### propTypes

- props의 type을 지정할 때는 propTypes를 사용한다.



```js
# App.js

import React, { Component } from 'react';
import MyComponent from './components/MyComponent';

class App extends Component {
  render() {
    return (
      <React.Fragment>
        <MyComponent name="React"/>
        <MyComponent />
        <MyComponent name={300}/>
      </React.Fragment>
    );
  }
}

export default App;
```



```js
# MyComponent.js

import React, { Component } from 'react';
import propTypes from 'prop-types';

class MyComponent extends Component {
    render() {
        const {name} = this.props;
        return (
            <div>
                Hello {name}
            </div>
        );
    }
}

MyComponent.defaultProps = {
    name:'리액트'
};

MyComponent.propTypes = {
    name:propTypes.string
};
export default MyComponent;
```

![캡처](https://user-images.githubusercontent.com/42603919/80783114-972df600-8bb3-11ea-9235-46c4073837ee.PNG)



#### defaultProps와 propTypes

- class 내부에서 transform-class-properties 문법을 사용하여 설정 할 수도 있음



```js
# App.js

import React, { Component } from 'react';
import MyComponent from './components/MyComponent';

class App extends Component {
  render() {
    return (
      <React.Fragment>
        <MyComponent name="React"/>
        <MyComponent />
        <MyComponent name={300}/>
      </React.Fragment>
    );
  }
}

export default App;
```



```js
# MyComponent.js

import React, { Component } from 'react';
import propTypes from 'prop-types';

class MyComponent extends Component {

    static defaultProps = {
        name:'리액트 default',
    }

    static propTypes = {
        name:propTypes.string
    }

    render() {
        const {name} = this.props;
        return (
            <div>
                Hello {name}
            </div>
        );
    }
}
export default MyComponent;
```

![캡처](https://user-images.githubusercontent.com/42603919/80783261-20452d00-8bb4-11ea-8a16-693f0fb849ba.PNG)



#### 필수 propTypes 설정

- propTypes를 설정할 때 뒤에 isRequired를 붙여 주면 된다.



```js
# App.js

import React, { Component } from 'react';
import MyComponent from './components/MyComponent';

class App extends Component {
  render() {
    return (
      <React.Fragment>
        <MyComponent name="React" age={10}/>
        <MyComponent />
        <MyComponent name={300}/>
        <MyComponent age={20}/>
      </React.Fragment>
    );
  }
}

export default App;
```



```js
# MyComponent.js

import React, { Component } from 'react';
import propTypes from 'prop-types';

class MyComponent extends Component {

    static defaultProps = {
        name:'리액트 default',
    }

    static propTypes = {
        name:propTypes.string,
        age:propTypes.number.isRequired
    }

    render() {
        const {name, age} = this.props;
        return (
            <div>
                Hello {name} / {age}
            </div>
        );
    }
}
export default MyComponent;
```

![캡처](https://user-images.githubusercontent.com/42603919/80783476-e6c0f180-8bb4-11ea-98e9-8f75d37e316c.PNG)



#### 함수형 컴포넌트

- props만 받아와서 보여 주기만 하는 컴포넌트의 경우에는 함수 형태로 컴포넌트를 작성할 수 있다.

- const {name, age} = this.props; 사용x

```js
# App.js

import React, { Component } from 'react';
import MyComponent from './components/MyComponent';
import MyComponentFunc from './components/MyComponentFunc';

class App extends Component {
  render() {
    return (
      <React.Fragment>
        <MyComponentFunc name="함수형 컴포넌트" age={15}/>
      </React.Fragment>
    );
  }
}

export default App;
```



```js
# MyComponentFunc.js

import React from 'react';

const MyComponentFunc = ({name, age}) => {
    return (
        <div>
            부모로부터 받은 상태변수 {name} / {age}
        </div>
    );
}

export default MyComponentFunc;
```

![캡처](https://user-images.githubusercontent.com/42603919/80784541-52f12480-8bb8-11ea-9243-44ce79ddec4c.PNG)



---



#### State [실습]

- **컴포넌트 내부에서 읽거나 변경할 수 있는 값을 사용 하려면 state를 사용** 해야 합니다.
- state는 언제나 기본값을 미리 설정 가능하며, **this.setState() 메서드를 통해서만 값을 변경**할 수 있음



#### state 초기값 설정

- constructor 메서드 안에서 state의 초기값을 설정할 수 있다.



#### state 값 변경

- state 값을 업데이트 할 때는 this.setState() 메서드를 사용한다.

```js
this.setState({
  수정할 필드 이름:값,
  수정할 또 다른 필드 이름:값
});
```



```js
# App.js

import React, { Component } from 'react';
import MyComponent from './components/MyComponent';
import MyComponentFunc from './components/MyComponentFunc';

class App extends Component {
  render() {
    return (
      <React.Fragment>
        <MyComponent name="React" age={10}/>
        <MyComponentFunc name="함수형 컴포넌트" age={15}/>
      </React.Fragment>
    );
  }
}

export default App;
```



```js
# MyComponent.js

import React, { Component } from 'react';
import propTypes from 'prop-types';

class MyComponent extends Component {


    //state variable
    state = {
        number:0
    }

    render() {
        const {name, age} = this.props;
        const {number} = this.state;

        return (
            <div>
                Hello {name} / {age}
                <p>Number 값 : {number}</p>
                <button onClick={() => (this.setState({
                    number:number + 1
                }))}>증가</button>
            </div>
        );
    }
}

export default MyComponent;
```

![캡처](https://user-images.githubusercontent.com/42603919/80785232-90ef4800-8bba-11ea-8d66-a99c81ae1b92.PNG)



#### state 를 constructor에서 꺼내기

- 증가시키는 것과 감소하는 것 비교해보기

```js
# MyComponent.js

import React, { Component } from 'react';
import propTypes from 'prop-types';

class MyComponent extends Component {

    static defaultProps = {
        name:'리액트 default',
    }

    static propTypes = {
        name:propTypes.string,
        age:propTypes.number.isRequired
    }

    //state variable
    state = {
        number:0
    }

    //number값을 감소시키는 함수
    handleDecrease = () => {
        this.setState({
            number:this.state.number - 1
        });
    }

    render() {
        const {name, age} = this.props;
        const {number} = this.state;
        const {handleDecrease} = this;

        return (
            <div>
                Hello {name} / {age}
                <p>Number 값 : {number}</p>
                <button onClick={() => (this.setState({
                    number:number + 1
                }))}>증가</button>

                <button onClick={handleDecrease}>감소</button>
            </div>
        );
    }
}

export default MyComponent;
```

![캡처](https://user-images.githubusercontent.com/42603919/80785875-c006b900-8bbc-11ea-8fd0-e41c50d7d956.PNG)



---



#### React의 Event Handling 

- DOM 요소에만 이벤트를 설정할 수 있습니다.
  - div, button, input, form, span 등 DOM 요소에는 이벤트를 설정할 수 있지만, 직접 만든 컴포넌트 에는 이벤트를 설정할 수 없다.



```js
# MyComponent.js

import React, { Component } from 'react';
import propTypes from 'prop-types';

class MyComponent extends Component {

    //state variable
    state = {
        number:0,
        message:''
    }

    //number값을 감소시키는 함수
    handleDecrease = (e) => {
        console.log(e.target);
        this.setState({
            number:this.state.number - 1
        });
    }
	
    //message 변화 감지
    handleChange = (e) => {
        this.setState({
            message:e.target.value
        });
    }

    render() {
        const {name, age} = this.props;
        const {number, message} = this.state;
        const {handleDecrease, handleChange} = this;


        return (
            <div>
                Hello {name} / {age}
                <p>Number 값 : {number}</p>
                <button onClick={() => (this.setState({
                    number:number + 1
                }))}>증가</button>

                <button onClick={handleDecrease} value="decrease">감소</button> <br/>
                <input type="text" value={message} onChange={handleChange}/> <br/>
                <button onClick={() => {this.setState({message:''})}}>초기화</button>

            </div>
        );
    }
}

export default MyComponent;
```

- ```js
  <input type="text" value={message} onChange={handleChange}/>
  ```

<img src="https://user-images.githubusercontent.com/42603919/80789570-4e803800-8bc7-11ea-9f38-c1b5eb1273c5.PNG" alt="캡처" style="zoom: 80%;" />

- **handleChange()**

![image](https://user-images.githubusercontent.com/42603919/80789583-56d87300-8bc7-11ea-9603-d14284517931.png)



- ```js
  <button onClick={() => {this.setState({message:''})}}>초기화</button>
  ```



<img src="https://user-images.githubusercontent.com/42603919/80789675-a61ea380-8bc7-11ea-80d8-ad7ff66c8b5b.PNG" alt="캡처" style="zoom:80%;" />



#### 여러 개의 input 과 state 관리

```js
import React, { Component } from 'react';
class EventPractice extends Component {
	state = { message: '', username: '' }
	handleChange = (e) => {
	this.setState({
	[e.target.name]:e.target.value
	});
	}
	handleClick = () => {
	alert(this.state.username + ':' + this.state.message);
	this.setState({
	message:'',
	username:''
	});
	}
	<input name="message" value={this.state.username} onChange={this.handleChange} />
	<input name="username" value={this.state.message} onChange={this.handleChange} />
	<button onClick={this.handleClick}>확인</button>
}

```



#### ref:DOM에 이름 달기

```js
<input type="text" value={message} onChange={handleChange}
                ref={(ref) => this.mymessage=ref}/> <br/>
                
<button onClick={() => (this.mymessage.focus())}>포커스 주기</button>
```



#### 컴포넌트 반복

##### map() 함수

- arr.map(callback, [thisArg]) 
  - 1) callback : 새로운 배열의 요소를 생성하는 함수이며, 파라미터는 다음 3가지
    - currentValue : 현재 처리하고 있는 요소
    - index : 현재 처리하고 있는 요소의 index 값
    - array : 현재 처리하고 있는 원본 배열 
  - 2) thisArg(선택항목) : callback 함수 내부에서 사용할 this 레퍼런스



##### key

- 리액트에서 key는 배열을 렌더링 했을 때 어떤 엘리먼트에 변동이 있었는지 알아낼 때 사용한다. 
  - 1) key가 없으면 - 가상 DOM을 비교하는 과정에서 리스트를 순차적으로 모두 비교하여 변화를 감지한다. 
  - 2) key가 있으면 - key값을 사용하여 어떤 변화가 일어 났는지 빠르게 감지할 수 있다.



##### 배열에 데이터 추가 기능 구현

-  초기 state 설정하기 : const로 정의 했던 배열을 state에 저장한다.
-  데이터 추가를 위한 input과 button을 렌더링 하고, 이벤트 핸들러 메서드 구현한다.

```js
# MyComponent.js

import React, { Component } from 'react';
import propTypes from 'prop-types';

class MyComponent extends Component {

    //state variable
    state = {
        number:0,
        message:'',
        messages:['Angular', 'React', 'Vue', 'Embar']
    }

    //number값을 감소시키는 함수
    handleDecrease = (e) => {
        console.log(e.target);
        this.setState({
            number:this.state.number - 1
        });
    }

    handleChange = (e) => {
        this.setState({
            message:e.target.value
        });
    }

    render() {
        const {name, age} = this.props;
        const {number, message, messages} = this.state;
        const {handleDecrease, handleChange} = this;
        const msgList = messages.map((msg,idx) => (
            <li key={idx}>{msg}</li>
        ));


        return (
            <div>
                Hello {name} / {age}
                <p>Number 값 : {number}</p>
                <button onClick={() => (this.setState({
                    number:number + 1
                }))}>증가</button>

                <button onClick={handleDecrease} value="decrease">감소</button> <br/>
                <input type="text" value={message} onChange={handleChange}
                ref={(ref) => this.mymessage=ref}/> <br/>
                <button onClick={() => {this.setState({message:''})}}>초기화</button>
                <button onClick={() => (this.mymessage.focus())}>포커스 주기</button>

                <ul>
                    {msgList}
                </ul>
            </div>
        );
    }
}

export default MyComponent;
```

<img src="https://user-images.githubusercontent.com/42603919/80792085-8fc81600-8bce-11ea-888c-66fcf68a0f0c.PNG" alt="캡처" style="zoom:80%;" />



#### 배열에 데이터 추가기능 구현

```js
# MyComponent.js

import React, { Component } from 'react';
import propTypes from 'prop-types';

class MyComponent extends Component {

    //state variable
    state = {
        number:0,
        message:'',
        messages:['Angular', 'React', 'Vue', 'Embar']
    }

    //number값을 감소시키는 함수
    handleDecrease = (e) => {
        console.log(e.target);
        this.setState({
            number:this.state.number - 1
        });
    }

    handleChange = (e) => {
        this.setState({
            message:e.target.value
        });
    }

    handleInsert = () => {
        const {message, messages} = this.state;
        this.setState({
            messages:messages.concat(message),
            message:''
        });
    }

    handleEnter = (e) => {
        if(e.key === 'Enter'){
            this.handleInsert();
        }
    }

    render() {
        const {name, age} = this.props;
        const {number, message, messages} = this.state;
        const {handleDecrease, handleChange, handleInsert, handleEnter} = this;
        const msgList = messages.map((msg,idx) => (
            <li key={idx}>{msg}</li>
        ));


        return (
            <div>
                Hello {name} / {age}
                <p>Number 값 : {number}</p>
                <button onClick={() => (this.setState({
                    number:number + 1
                }))}>증가</button>

                <button onClick={handleDecrease} value="decrease">감소</button> <br/>
                <button onClick={() => (this.mymessage.focus())}>포커스 주기</button> <br/>
                <input type="text" value={message} onChange={handleChange}
                ref={(ref) => this.mymessage=ref}
                onKeyPress={handleEnter}/> <br/>
                <button onClick={handleInsert}>추가</button>
                <button onClick={() => {this.setState({message:''})}}>초기화</button>
                

                <ul>
                    {msgList}
                </ul>
            </div>
        );
    }
}

export default MyComponent;
```

<img src="https://user-images.githubusercontent.com/42603919/80792350-3a403900-8bcf-11ea-9557-d256228822f2.PNG" alt="캡처" style="zoom:80%;" />



<img src="https://user-images.githubusercontent.com/42603919/80792352-3ad8cf80-8bcf-11ea-8ec4-88230066b3ec.PNG" alt="1" style="zoom:80%;" />



#### 배열에 데이터 삭제기능 구현(더블클릭하면 지워지도록)

```js
# MyComponent.js

import React, { Component } from 'react';
import propTypes from 'prop-types';

class MyComponent extends Component {

    //state variable
    state = {
        number:0,
        message:'',
        messages:['Angular', 'React', 'Vue', 'Embar']
    }

    //number값을 감소시키는 함수
    handleDecrease = (e) => {
        console.log(e.target);
        this.setState({
            number:this.state.number - 1
        });
    }

    handleChange = (e) => {
        this.setState({
            message:e.target.value
        });
    }

    handleInsert = () => {
        const {message, messages} = this.state;
        this.setState({
            messages:messages.concat(message),
            message:''
        });
    }

    handleEnter = (e) => {
        if(e.key === 'Enter'){
            this.handleInsert();
        }
    };

    handleRemove = (index) => {
        this.setState({
            messages:this.state.messages.filter((item, idx) => (idx != index))
        });
        
    };

    render() {
        const {name, age} = this.props;
        const {number, message, messages} = this.state;
        const {handleDecrease, handleChange, handleInsert, handleEnter, handleRemove} = this;
        const msgList = messages.map((msg,idx) => (
            <li key={idx} onDoubleClick={() => handleRemove(idx)}>{msg}</li>
        ));


        return (
            <div>
                Hello {name} / {age}
                <p>Number 값 : {number}</p>
                <button onClick={() => (this.setState({
                    number:number + 1
                }))}>증가</button>

                <button onClick={handleDecrease} value="decrease">감소</button> <br/>
                <button onClick={() => (this.mymessage.focus())}>포커스 주기</button> <br/>
                <input type="text" value={message} onChange={handleChange}
                ref={(ref) => this.mymessage=ref}
                onKeyPress={handleEnter}/> <br/>
                <button onClick={handleInsert}>추가</button>
                <button onClick={() => {this.setState({message:''})}}>초기화</button>
                

                <ul>
                    {msgList}
                </ul>
            </div>
        );
    }
}

export default MyComponent;
```

