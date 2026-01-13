## [1.43.2](https://github.com/algolia/algoliasearch-client-dart/compare/1.43.1...1.43.2)

- [cd7a174b4](https://github.com/algolia/api-clients-automation/commit/cd7a174b4) fix(specs): BREAKING CHANGE — remove fields requirement from run response in CompAPI client ([#5809](https://github.com/algolia/api-clients-automation/pull/5809)) by [@ClaraMuller](https://github.com/ClaraMuller/)\
Some fields from the Composition Run search response were marked as required while they were optional on the API side. This has been fixed, but might impact the client types.

## [1.43.1](https://github.com/algolia/algoliasearch-client-dart/compare/1.43.0...1.43.1)

- [54606b3b2](https://github.com/algolia/api-clients-automation/commit/54606b3b2) refactor(specs): extract `results` field in a dedicated directory ([#5739](https://github.com/algolia/api-clients-automation/pull/5739)) by [@ClaraMuller](https://github.com/ClaraMuller/)
- [3296a5033](https://github.com/algolia/api-clients-automation/commit/3296a5033) chore(deps): dependencies 2025-11-24 ([#5653](https://github.com/algolia/api-clients-automation/pull/5653)) by [@algolia-bot](https://github.com/algolia-bot/)
- [5dabdc540](https://github.com/algolia/api-clients-automation/commit/5dabdc540) refactor(specs): re-organise response for Composition API ([#5744](https://github.com/algolia/api-clients-automation/pull/5744)) by [@ClaraMuller](https://github.com/ClaraMuller/)
- [3d86676b0](https://github.com/algolia/api-clients-automation/commit/3d86676b0) fix(specs): update list with NLU permissions ([#5769](https://github.com/algolia/api-clients-automation/pull/5769)) by [@MarioAlexandruDan](https://github.com/MarioAlexandruDan/)

## [1.43.0](https://github.com/algolia/algoliasearch-client-dart/compare/1.42.0...1.43.0)

- [5335918a5](https://github.com/algolia/api-clients-automation/commit/5335918a5) chore(scripts): update the jira action ([#5678](https://github.com/algolia/api-clients-automation/pull/5678)) by [@millotp](https://github.com/millotp/)
- [d6bde0f0c](https://github.com/algolia/api-clients-automation/commit/d6bde0f0c) chore(scripts): remove component from jira ticket ([#5680](https://github.com/algolia/api-clients-automation/pull/5680)) by [@millotp](https://github.com/millotp/)
- [fe6e82c11](https://github.com/algolia/api-clients-automation/commit/fe6e82c11) feat(specs): add sortBy query param and sortingStrategy ([#5686](https://github.com/algolia/api-clients-automation/pull/5686)) by [@ben-kalmus](https://github.com/ben-kalmus/)
- [cccfa9c86](https://github.com/algolia/api-clients-automation/commit/cccfa9c86) feat(specs): add `sortBy` trigger on Composition Rules ([#5707](https://github.com/algolia/api-clients-automation/pull/5707)) by [@ClaraMuller](https://github.com/ClaraMuller/)

## [1.42.0](https://github.com/algolia/algoliasearch-client-dart/compare/1.41.1...1.42.0)

- [6a48ef151a](https://github.com/algolia/api-clients-automation/commit/6a48ef151a) feat(specs): allow `enablePersonalization` query parameter at run time for Composition API ([#5651](https://github.com/algolia/api-clients-automation/pull/5651)) by [@ClaraMuller](https://github.com/ClaraMuller/)

## [1.41.1](https://github.com/algolia/algoliasearch-client-dart/compare/1.41.0...1.41.1)

- [ee5542a32](https://github.com/algolia/api-clients-automation/commit/ee5542a32) fix(specs): Add title values to key oneOfs ([#5581](https://github.com/algolia/api-clients-automation/pull/5581)) by [@gazconroy](https://github.com/gazconroy/)
- [ae9ac597f](https://github.com/algolia/api-clients-automation/commit/ae9ac597f) fix(specs): add tags and scope to rules ([#5625](https://github.com/algolia/api-clients-automation/pull/5625)) by [@millotp](https://github.com/millotp/)

## [1.41.0](https://github.com/algolia/algoliasearch-client-dart/compare/1.40.0...1.41.0)

- [ecfea56dc](https://github.com/algolia/api-clients-automation/commit/ecfea56dc) feat(clients): remove schedule capabilities ([#5552](https://github.com/algolia/api-clients-automation/pull/5552)) by [@cdhawke](https://github.com/cdhawke/)
- [ff4b8f02c](https://github.com/algolia/api-clients-automation/commit/ff4b8f02c) feat(specs): add fallbackParameters to Frequently bought together [RECO-2443] ([#5579](https://github.com/algolia/api-clients-automation/pull/5579)) by [@raed667](https://github.com/raed667/)

## [1.40.0](https://github.com/algolia/algoliasearch-client-dart/compare/1.39.0...1.40.0)

- [d9b21b4b1](https://github.com/algolia/api-clients-automation/commit/d9b21b4b1) feat(specs): add `renderingContent` query parameter in Composition API main injection ([#5549](https://github.com/algolia/api-clients-automation/pull/5549)) by [@ClaraMuller](https://github.com/ClaraMuller/)
- [1eee2a5f7](https://github.com/algolia/api-clients-automation/commit/1eee2a5f7) fix(specs): add ACL to missing endpoints ([#5529](https://github.com/algolia/api-clients-automation/pull/5529)) by [@millotp](https://github.com/millotp/)
- [38ae444d7](https://github.com/algolia/api-clients-automation/commit/38ae444d7) feat(specs): add specific documentation for `facets` query parameter in Composition API ([#5477](https://github.com/algolia/api-clients-automation/pull/5477)) by [@ClaraMuller](https://github.com/ClaraMuller/)

## [1.39.0](https://github.com/algolia/algoliasearch-client-dart/compare/1.38.1...1.39.0)

- [7287faaa7](https://github.com/algolia/api-clients-automation/commit/7287faaa7) feat(specs): add `facets` query parameter available at run time ([#5486](https://github.com/algolia/api-clients-automation/pull/5486)) by [@ClaraMuller](https://github.com/ClaraMuller/)

## [1.38.1](https://github.com/algolia/algoliasearch-client-dart/compare/1.38.0...1.38.1)

- [9a92b3269](https://github.com/algolia/api-clients-automation/commit/9a92b3269) chore(deps): dependencies 2025-10-13 ([#5453](https://github.com/algolia/api-clients-automation/pull/5453)) by [@algolia-bot](https://github.com/algolia-bot/)
- [02b6a90ae](https://github.com/algolia/api-clients-automation/commit/02b6a90ae) fix(clients): upgrade linter ([#5476](https://github.com/algolia/api-clients-automation/pull/5476)) by [@millotp](https://github.com/millotp/)
- [3fc252bec](https://github.com/algolia/api-clients-automation/commit/3fc252bec) chore: remove dead links ([#5472](https://github.com/algolia/api-clients-automation/pull/5472)) by [@millotp](https://github.com/millotp/)

## [1.38.0](https://github.com/algolia/algoliasearch-client-dart/compare/1.37.0...1.38.0)

- [7de94353f](https://github.com/algolia/api-clients-automation/commit/7de94353f) feat(specs): add compositions deduplication setting ([#5418](https://github.com/algolia/api-clients-automation/pull/5418)) by [@ben-kalmus](https://github.com/ben-kalmus/)
- [8bee10f1a](https://github.com/algolia/api-clients-automation/commit/8bee10f1a) fix(clients): add a default idleConnTimeout ([#5442](https://github.com/algolia/api-clients-automation/pull/5442)) by [@millotp](https://github.com/millotp/)
- [01261eceb](https://github.com/algolia/api-clients-automation/commit/01261eceb) chore(deps): dependencies 2025-09-29 ([#5393](https://github.com/algolia/api-clients-automation/pull/5393)) by [@algolia-bot](https://github.com/algolia-bot/)

## [1.37.0](https://github.com/algolia/algoliasearch-client-dart/compare/1.36.1...1.37.0)

- [ca25c44e2](https://github.com/algolia/api-clients-automation/commit/ca25c44e2) chore(deps): dependencies 2025-09-08 ([#5310](https://github.com/algolia/api-clients-automation/pull/5310)) by [@algolia-bot](https://github.com/algolia-bot/)
- [323e06d6f](https://github.com/algolia/api-clients-automation/commit/323e06d6f) chore(deps): dependencies 2025-09-15 ([#5341](https://github.com/algolia/api-clients-automation/pull/5341)) by [@algolia-bot](https://github.com/algolia-bot/)
- [9884be690](https://github.com/algolia/api-clients-automation/commit/9884be690) feat(specs): merge `composition` & `composition-full` ([#5333](https://github.com/algolia/api-clients-automation/pull/5333)) by [@ClaraMuller](https://github.com/ClaraMuller/)

## [1.36.1](https://github.com/algolia/algoliasearch-client-dart/compare/1.36.0...1.36.1)

- [8f4abf3a1](https://github.com/algolia/api-clients-automation/commit/8f4abf3a1) fix(specs): Cross-reference filerPromotes to relevant guide ([#5279](https://github.com/algolia/api-clients-automation/pull/5279)) by [@gazconroy](https://github.com/gazconroy/)
- [08e9d1888](https://github.com/algolia/api-clients-automation/commit/08e9d1888) fix(specs): add getVersion parameter to getSettings ([#5254](https://github.com/algolia/api-clients-automation/pull/5254)) by [@millotp](https://github.com/millotp/)
- [716aa852f](https://github.com/algolia/api-clients-automation/commit/716aa852f) chore(deps): dependencies 2025-09-01 ([#5285](https://github.com/algolia/api-clients-automation/pull/5285)) by [@algolia-bot](https://github.com/algolia-bot/)
- [f4eee1c4a](https://github.com/algolia/api-clients-automation/commit/f4eee1c4a) chore(website): exclude schema from generated variables file ([#5306](https://github.com/algolia/api-clients-automation/pull/5306)) by [@Fluf22](https://github.com/Fluf22/)
- [2fa0389f8](https://github.com/algolia/api-clients-automation/commit/2fa0389f8) fix(clients): link to support/help center on unreachable hosts ([#5305](https://github.com/algolia/api-clients-automation/pull/5305)) by [@shortcuts](https://github.com/shortcuts/)

## [1.36.0](https://github.com/algolia/algoliasearch-client-dart/compare/1.35.0...1.36.0)

- [48672036c1](https://github.com/algolia/api-clients-automation/commit/48672036c1) refactor(specs): mutualise code between Search API & Comp API for search query parameters ([#5125](https://github.com/algolia/api-clients-automation/pull/5125)) by [@ClaraMuller](https://github.com/ClaraMuller/)
- [ca6f3ca016](https://github.com/algolia/api-clients-automation/commit/ca6f3ca016) fix(specs): define batch actions ([#5242](https://github.com/algolia/api-clients-automation/pull/5242)) by [@kai687](https://github.com/kai687/)
- [99f8174c7d](https://github.com/algolia/api-clients-automation/commit/99f8174c7d) feat(specs): add fields for metadata in composition injectedItems ([#5241](https://github.com/algolia/api-clients-automation/pull/5241)) by [@gavinwade12](https://github.com/gavinwade12/)
- [ff178d8118](https://github.com/algolia/api-clients-automation/commit/ff178d8118) feat(specs): abtests stopped at ([#5275](https://github.com/algolia/api-clients-automation/pull/5275)) by [@stevenMevans](https://github.com/stevenMevans/)

## [1.35.0](https://github.com/algolia/algoliasearch-client-dart/compare/1.34.2...1.35.0)

- [050aacef17](https://github.com/algolia/api-clients-automation/commit/050aacef17) chore(deps): dependencies 2025-07-28 ([#5161](https://github.com/algolia/api-clients-automation/pull/5161)) by [@algolia-bot](https://github.com/algolia-bot/)
- [66bc4eee9e](https://github.com/algolia/api-clients-automation/commit/66bc4eee9e) feat(clients): add new abtesting-v3 package to clients + stabilize alpha js package ([#5157](https://github.com/algolia/api-clients-automation/pull/5157)) by [@leonardogavaudan](https://github.com/leonardogavaudan/)

## [1.34.2](https://github.com/algolia/algoliasearch-client-dart/compare/1.34.1...1.34.2)

- [9b7b0324df](https://github.com/algolia/api-clients-automation/commit/9b7b0324df) fix(dart): deps constraints for null-aware-elements ([#5128](https://github.com/algolia/api-clients-automation/pull/5128)) by [@shortcuts](https://github.com/shortcuts/)
- [84a1f4e422](https://github.com/algolia/api-clients-automation/commit/84a1f4e422) refactor(specs): add interface to manipulate query parameter between composition API & Search API ([#5123](https://github.com/algolia/api-clients-automation/pull/5123)) by [@ClaraMuller](https://github.com/ClaraMuller/)

## [1.34.1](https://github.com/algolia/algoliasearch-client-dart/compare/1.34.0...1.34.1)

- [754efceb80](https://github.com/algolia/api-clients-automation/commit/754efceb80) fix(specs): allow one sided rule validity ([#5060](https://github.com/algolia/api-clients-automation/pull/5060)) by [@millotp](https://github.com/millotp/)

## [1.34.0](https://github.com/algolia/algoliasearch-client-dart/compare/1.33.1...1.34.0)

- [a2ebbf496c](https://github.com/algolia/api-clients-automation/commit/a2ebbf496c) feat(clients): add `replaceAllObjectsWithTransformation` ([#5008](https://github.com/algolia/api-clients-automation/pull/5008)) by [@shortcuts](https://github.com/shortcuts/)
- [5e3869931b](https://github.com/algolia/api-clients-automation/commit/5e3869931b) chore(spec): fix comment of custom path ([#5014](https://github.com/algolia/api-clients-automation/pull/5014)) by [@millotp](https://github.com/millotp/)

## [1.33.1](https://github.com/algolia/algoliasearch-client-dart/compare/1.33.0...1.33.1)

- [60ade79465](https://github.com/algolia/api-clients-automation/commit/60ade79465) chore(deps): dependencies 2025-06-16 ([#4977](https://github.com/algolia/api-clients-automation/pull/4977)) by [@algolia-bot](https://github.com/algolia-bot/)
- [2561c945f7](https://github.com/algolia/api-clients-automation/commit/2561c945f7) fix(clients): processingTimeMS should be optional ([#5004](https://github.com/algolia/api-clients-automation/pull/5004)) by [@Fluf22](https://github.com/Fluf22/)

## [1.33.0](https://github.com/algolia/algoliasearch-client-dart/compare/1.32.1...1.33.0)

- [835daccb48](https://github.com/algolia/api-clients-automation/commit/835daccb48) feat(specs): add with transformation helpers ([#4931](https://github.com/algolia/api-clients-automation/pull/4931)) by [@shortcuts](https://github.com/shortcuts/)

## [1.32.1](https://github.com/algolia/algoliasearch-client-dart/compare/1.32.0...1.32.1)

- [9db03b532b](https://github.com/algolia/api-clients-automation/commit/9db03b532b) fix(specs): typo ([#4854](https://github.com/algolia/api-clients-automation/pull/4854)) by [@kai687](https://github.com/kai687/)
- [1951e4d127](https://github.com/algolia/api-clients-automation/commit/1951e4d127) fix(specs): wrong ACL for getSettings ([#4933](https://github.com/algolia/api-clients-automation/pull/4933)) by [@kai687](https://github.com/kai687/)

## [1.32.0](https://github.com/algolia/algoliasearch-client-dart/compare/1.31.3...1.32.0)

- [bebb56e0b9](https://github.com/algolia/api-clients-automation/commit/bebb56e0b9) fix(specs): add x-acl to insights endpoints ([#4822](https://github.com/algolia/api-clients-automation/pull/4822)) by [@kai687](https://github.com/kai687/)
- [7e226c4559](https://github.com/algolia/api-clients-automation/commit/7e226c4559) feat(scripts): add push to mcp-node on release ([#4784](https://github.com/algolia/api-clients-automation/pull/4784)) by [@shortcuts](https://github.com/shortcuts/)

## [1.31.3](https://github.com/algolia/algoliasearch-client-dart/compare/1.31.2...1.31.3)

- [369c14232](https://github.com/algolia/api-clients-automation/commit/369c14232) fix(specs): condition cant be numeric filter ([#4726](https://github.com/algolia/api-clients-automation/pull/4726)) by [@kai687](https://github.com/kai687/)
- [4570f18b8](https://github.com/algolia/api-clients-automation/commit/4570f18b8) fix(clients): correctly deserialize SearchResult ([#4756](https://github.com/algolia/api-clients-automation/pull/4756)) by [@millotp](https://github.com/millotp/)

## [1.31.2](https://github.com/algolia/algoliasearch-client-dart/compare/1.31.1...1.31.2)

- [dbaef6696](https://github.com/algolia/api-clients-automation/commit/dbaef6696) fix(specs): userData is any type ([#4702](https://github.com/algolia/api-clients-automation/pull/4702)) by [@millotp](https://github.com/millotp/)
- [a922dca5a](https://github.com/algolia/api-clients-automation/commit/a922dca5a) docs(partialUpdate): add note about multiple operations ([#4721](https://github.com/algolia/api-clients-automation/pull/4721)) by [@Jerska](https://github.com/Jerska/)

## [1.31.1](https://github.com/algolia/algoliasearch-client-dart/compare/1.31.0...1.31.1)

- [a51683025e](https://github.com/algolia/api-clients-automation/commit/a51683025e) chore: deprecate mcm methods ([#4694](https://github.com/algolia/api-clients-automation/pull/4694)) by [@kai687](https://github.com/kai687/)

## [1.31.0](https://github.com/algolia/algoliasearch-client-dart/compare/1.30.2...1.31.0)

- [3994f53d4](https://github.com/algolia/api-clients-automation/commit/3994f53d4) feat(clients): add new realtime-personalization api ([#4613](https://github.com/algolia/api-clients-automation/pull/4613)) by [@benamib](https://github.com/benamib/)
- [6d8c0548d](https://github.com/algolia/api-clients-automation/commit/6d8c0548d) chore: do not generate realtime personalization ([#4655](https://github.com/algolia/api-clients-automation/pull/4655)) by [@shortcuts](https://github.com/shortcuts/)

## [1.30.2](https://github.com/algolia/algoliasearch-client-dart/compare/1.30.1...1.30.2)

- [4f68190e10](https://github.com/algolia/api-clients-automation/commit/4f68190e10) fix(specs): update Recommend maxRecommendations to 30 max [RECO-2361] ([#4483](https://github.com/algolia/api-clients-automation/pull/4483)) by [@raed667](https://github.com/raed667/)
- [92bd911848](https://github.com/algolia/api-clients-automation/commit/92bd911848) chore(scripts): point jira issues to another epic ([#4505](https://github.com/algolia/api-clients-automation/pull/4505)) by [@millotp](https://github.com/millotp/)
- [97d2722bc9](https://github.com/algolia/api-clients-automation/commit/97d2722bc9) fix(specs): Increase optionalWords visibility in docs ([#4559](https://github.com/algolia/api-clients-automation/pull/4559)) by [@gazconroy](https://github.com/gazconroy/)

## [1.30.1](https://github.com/algolia/algoliasearch-client-dart/compare/1.30.0...1.30.1)

- [7698297bcd](https://github.com/algolia/api-clients-automation/commit/7698297bcd) fix(dart): version test ([#4387](https://github.com/algolia/api-clients-automation/pull/4387)) by [@shortcuts](https://github.com/shortcuts/)
- [d91947dc11](https://github.com/algolia/api-clients-automation/commit/d91947dc11) fix(dart): add readme for composition ([#4389](https://github.com/algolia/api-clients-automation/pull/4389)) by [@millotp](https://github.com/millotp/)
- [506b8a5636](https://github.com/algolia/api-clients-automation/commit/506b8a5636) fix(specs): responseFields description ([#4399](https://github.com/algolia/api-clients-automation/pull/4399)) by [@kai687](https://github.com/kai687/)

## [1.30.0](https://github.com/algolia/algoliasearch-client-dart/compare/1.29.0...1.30.0)

- [b012ca8f20](https://github.com/algolia/api-clients-automation/commit/b012ca8f20) chore: wait before release ([#4323](https://github.com/algolia/api-clients-automation/pull/4323)) by [@shortcuts](https://github.com/shortcuts/)
- [1e847f4caf](https://github.com/algolia/api-clients-automation/commit/1e847f4caf) fix(specs): move customRanking and keepDiacriticsOnCharacters to indexSettings ([#4324](https://github.com/algolia/api-clients-automation/pull/4324)) by [@millotp](https://github.com/millotp/)
- [57d528a481](https://github.com/algolia/api-clients-automation/commit/57d528a481) feat(clients): endpoint level timeout part 2 ([#4318](https://github.com/algolia/api-clients-automation/pull/4318)) by [@Fluf22](https://github.com/Fluf22/)
- [952639f0fb](https://github.com/algolia/api-clients-automation/commit/952639f0fb) fix(specs): adjust style for banner descriptions ([#4362](https://github.com/algolia/api-clients-automation/pull/4362)) by [@kai687](https://github.com/kai687/)
- [83f188d333](https://github.com/algolia/api-clients-automation/commit/83f188d333) feat(specs): rename composition to composition-full (private) and add composition (public) ([#4357](https://github.com/algolia/api-clients-automation/pull/4357)) by [@e-krebs](https://github.com/e-krebs/)

