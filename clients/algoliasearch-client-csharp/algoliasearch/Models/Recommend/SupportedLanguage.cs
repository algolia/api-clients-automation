//
// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
//
using System;
using System.Text;
using System.Linq;
using System.Text.Json.Serialization;
using System.Collections.Generic;
using Algolia.Search.Serializer;
using System.Text.Json;

namespace Algolia.Search.Models.Recommend;

/// <summary>
/// ISO code for a supported language.
/// </summary>
/// <value>ISO code for a supported language.</value>
[JsonConverter(typeof(Serializer.JsonStringEnumConverter<SupportedLanguage>))]
public enum SupportedLanguage
{
  /// <summary>
  /// Enum Af for value: af
  /// </summary>
  [JsonPropertyName("af")]
  Af = 1,

  /// <summary>
  /// Enum Ar for value: ar
  /// </summary>
  [JsonPropertyName("ar")]
  Ar = 2,

  /// <summary>
  /// Enum Az for value: az
  /// </summary>
  [JsonPropertyName("az")]
  Az = 3,

  /// <summary>
  /// Enum Bg for value: bg
  /// </summary>
  [JsonPropertyName("bg")]
  Bg = 4,

  /// <summary>
  /// Enum Bn for value: bn
  /// </summary>
  [JsonPropertyName("bn")]
  Bn = 5,

  /// <summary>
  /// Enum Ca for value: ca
  /// </summary>
  [JsonPropertyName("ca")]
  Ca = 6,

  /// <summary>
  /// Enum Cs for value: cs
  /// </summary>
  [JsonPropertyName("cs")]
  Cs = 7,

  /// <summary>
  /// Enum Cy for value: cy
  /// </summary>
  [JsonPropertyName("cy")]
  Cy = 8,

  /// <summary>
  /// Enum Da for value: da
  /// </summary>
  [JsonPropertyName("da")]
  Da = 9,

  /// <summary>
  /// Enum De for value: de
  /// </summary>
  [JsonPropertyName("de")]
  De = 10,

  /// <summary>
  /// Enum El for value: el
  /// </summary>
  [JsonPropertyName("el")]
  El = 11,

  /// <summary>
  /// Enum En for value: en
  /// </summary>
  [JsonPropertyName("en")]
  En = 12,

  /// <summary>
  /// Enum Eo for value: eo
  /// </summary>
  [JsonPropertyName("eo")]
  Eo = 13,

  /// <summary>
  /// Enum Es for value: es
  /// </summary>
  [JsonPropertyName("es")]
  Es = 14,

  /// <summary>
  /// Enum Et for value: et
  /// </summary>
  [JsonPropertyName("et")]
  Et = 15,

  /// <summary>
  /// Enum Eu for value: eu
  /// </summary>
  [JsonPropertyName("eu")]
  Eu = 16,

  /// <summary>
  /// Enum Fa for value: fa
  /// </summary>
  [JsonPropertyName("fa")]
  Fa = 17,

  /// <summary>
  /// Enum Fi for value: fi
  /// </summary>
  [JsonPropertyName("fi")]
  Fi = 18,

  /// <summary>
  /// Enum Fo for value: fo
  /// </summary>
  [JsonPropertyName("fo")]
  Fo = 19,

  /// <summary>
  /// Enum Fr for value: fr
  /// </summary>
  [JsonPropertyName("fr")]
  Fr = 20,

  /// <summary>
  /// Enum Ga for value: ga
  /// </summary>
  [JsonPropertyName("ga")]
  Ga = 21,

  /// <summary>
  /// Enum Gl for value: gl
  /// </summary>
  [JsonPropertyName("gl")]
  Gl = 22,

  /// <summary>
  /// Enum He for value: he
  /// </summary>
  [JsonPropertyName("he")]
  He = 23,

  /// <summary>
  /// Enum Hi for value: hi
  /// </summary>
  [JsonPropertyName("hi")]
  Hi = 24,

  /// <summary>
  /// Enum Hu for value: hu
  /// </summary>
  [JsonPropertyName("hu")]
  Hu = 25,

  /// <summary>
  /// Enum Hy for value: hy
  /// </summary>
  [JsonPropertyName("hy")]
  Hy = 26,

  /// <summary>
  /// Enum Id for value: id
  /// </summary>
  [JsonPropertyName("id")]
  Id = 27,

  /// <summary>
  /// Enum Is for value: is
  /// </summary>
  [JsonPropertyName("is")]
  Is = 28,

  /// <summary>
  /// Enum It for value: it
  /// </summary>
  [JsonPropertyName("it")]
  It = 29,

  /// <summary>
  /// Enum Ja for value: ja
  /// </summary>
  [JsonPropertyName("ja")]
  Ja = 30,

  /// <summary>
  /// Enum Ka for value: ka
  /// </summary>
  [JsonPropertyName("ka")]
  Ka = 31,

  /// <summary>
  /// Enum Kk for value: kk
  /// </summary>
  [JsonPropertyName("kk")]
  Kk = 32,

  /// <summary>
  /// Enum Ko for value: ko
  /// </summary>
  [JsonPropertyName("ko")]
  Ko = 33,

  /// <summary>
  /// Enum Ku for value: ku
  /// </summary>
  [JsonPropertyName("ku")]
  Ku = 34,

  /// <summary>
  /// Enum Ky for value: ky
  /// </summary>
  [JsonPropertyName("ky")]
  Ky = 35,

  /// <summary>
  /// Enum Lt for value: lt
  /// </summary>
  [JsonPropertyName("lt")]
  Lt = 36,

  /// <summary>
  /// Enum Lv for value: lv
  /// </summary>
  [JsonPropertyName("lv")]
  Lv = 37,

  /// <summary>
  /// Enum Mi for value: mi
  /// </summary>
  [JsonPropertyName("mi")]
  Mi = 38,

  /// <summary>
  /// Enum Mn for value: mn
  /// </summary>
  [JsonPropertyName("mn")]
  Mn = 39,

  /// <summary>
  /// Enum Mr for value: mr
  /// </summary>
  [JsonPropertyName("mr")]
  Mr = 40,

  /// <summary>
  /// Enum Ms for value: ms
  /// </summary>
  [JsonPropertyName("ms")]
  Ms = 41,

  /// <summary>
  /// Enum Mt for value: mt
  /// </summary>
  [JsonPropertyName("mt")]
  Mt = 42,

  /// <summary>
  /// Enum Nb for value: nb
  /// </summary>
  [JsonPropertyName("nb")]
  Nb = 43,

  /// <summary>
  /// Enum Nl for value: nl
  /// </summary>
  [JsonPropertyName("nl")]
  Nl = 44,

  /// <summary>
  /// Enum No for value: no
  /// </summary>
  [JsonPropertyName("no")]
  No = 45,

  /// <summary>
  /// Enum Ns for value: ns
  /// </summary>
  [JsonPropertyName("ns")]
  Ns = 46,

  /// <summary>
  /// Enum Pl for value: pl
  /// </summary>
  [JsonPropertyName("pl")]
  Pl = 47,

  /// <summary>
  /// Enum Ps for value: ps
  /// </summary>
  [JsonPropertyName("ps")]
  Ps = 48,

  /// <summary>
  /// Enum Pt for value: pt
  /// </summary>
  [JsonPropertyName("pt")]
  Pt = 49,

  /// <summary>
  /// Enum PtBr for value: pt-br
  /// </summary>
  [JsonPropertyName("pt-br")]
  PtBr = 50,

  /// <summary>
  /// Enum Qu for value: qu
  /// </summary>
  [JsonPropertyName("qu")]
  Qu = 51,

  /// <summary>
  /// Enum Ro for value: ro
  /// </summary>
  [JsonPropertyName("ro")]
  Ro = 52,

  /// <summary>
  /// Enum Ru for value: ru
  /// </summary>
  [JsonPropertyName("ru")]
  Ru = 53,

  /// <summary>
  /// Enum Sk for value: sk
  /// </summary>
  [JsonPropertyName("sk")]
  Sk = 54,

  /// <summary>
  /// Enum Sq for value: sq
  /// </summary>
  [JsonPropertyName("sq")]
  Sq = 55,

  /// <summary>
  /// Enum Sv for value: sv
  /// </summary>
  [JsonPropertyName("sv")]
  Sv = 56,

  /// <summary>
  /// Enum Sw for value: sw
  /// </summary>
  [JsonPropertyName("sw")]
  Sw = 57,

  /// <summary>
  /// Enum Ta for value: ta
  /// </summary>
  [JsonPropertyName("ta")]
  Ta = 58,

  /// <summary>
  /// Enum Te for value: te
  /// </summary>
  [JsonPropertyName("te")]
  Te = 59,

  /// <summary>
  /// Enum Th for value: th
  /// </summary>
  [JsonPropertyName("th")]
  Th = 60,

  /// <summary>
  /// Enum Tl for value: tl
  /// </summary>
  [JsonPropertyName("tl")]
  Tl = 61,

  /// <summary>
  /// Enum Tn for value: tn
  /// </summary>
  [JsonPropertyName("tn")]
  Tn = 62,

  /// <summary>
  /// Enum Tr for value: tr
  /// </summary>
  [JsonPropertyName("tr")]
  Tr = 63,

  /// <summary>
  /// Enum Tt for value: tt
  /// </summary>
  [JsonPropertyName("tt")]
  Tt = 64,

  /// <summary>
  /// Enum Uk for value: uk
  /// </summary>
  [JsonPropertyName("uk")]
  Uk = 65,

  /// <summary>
  /// Enum Ur for value: ur
  /// </summary>
  [JsonPropertyName("ur")]
  Ur = 66,

  /// <summary>
  /// Enum Uz for value: uz
  /// </summary>
  [JsonPropertyName("uz")]
  Uz = 67,

  /// <summary>
  /// Enum Zh for value: zh
  /// </summary>
  [JsonPropertyName("zh")]
  Zh = 68
}

