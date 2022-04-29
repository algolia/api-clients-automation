## Cache

No input params (classic setup):
- Setup cache version
- restore yarn cache
- yarn install

job:

used to gen and run the CTS, and to push the codegen
'cts':
- (classic setup)
- all specs
- all clients from all languages (and common files)

used to generate a client, will load the cache up front and store in the post job.
'client_gen':
  - restore ONE spec if `input.spec` is provided
  - restore ONE client of the corresponding `language` if both `input.language` and `input.matrix` are provided

'algoliasearch_js':
- js algoliasearch client
- js search client
- js personalization client
- js analytics client


And finally there a js edge case because why not
language == 'javascript':
- common js client
- js requesters (node and browser)
