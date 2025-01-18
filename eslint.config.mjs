import globals from 'globals';
import pluginJs from '@eslint/js';
import pluginReact from 'eslint-plugin-react';

/** @type {import('eslint').Linter.Config[]} */
export default [
  {
    rules: {
      'no-unused-vars': 'warn',
      'no-undef': 'warn',
    },
  },
  {files: ['**/*.{js,mjs,cjs,jsx}']},
  {files: ['**/*.js'], languageOptions: {sourceType: 'commonjs'}},
  {
    languageOptions: {
      globals: globals.browser,
      sourceType: 'module',
      ecmaVersion: 'latest',
    },
  },
  pluginJs.configs.recommended,
  pluginReact.configs.flat.recommended,
];
