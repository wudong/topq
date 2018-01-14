import * as React from 'react';
import * as ReactDOM from 'react-dom';

import Hello from './components/Hello';

ReactDOM.render(
    <Hello name="Typescript" enthusiasmLevel={10}/>,
    document.getElementById('root') as HTMLElement
);